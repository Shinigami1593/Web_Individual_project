import { useEffect, useState } from "react";
import ProductCard from "../component/explore/ProductCard";
import fetchFromApi from "../services/api";
import SelectCategory from "../component/explore/SelectCategory";
import PriceFilter from "../component/explore/PriceFilter";
import "./ExploreProducts.css";
import { useParams } from "react-router-dom";
import Shimmer from "../component/shimmer/Shimmer";

interface Product {
  id: string;
  title: string;
  description: string;
  image: string;
  price: number;
  category: string;
}

interface CheckBoxState {
  men: boolean;
  women: boolean;
}

function ExploreProduct() {
  const [products, setProducts] = useState<Product[]>([]);
  const [priceFilter, setPriceFilter] = useState<string>("default");
  const [checkBoxState, setCheckBoxState] = useState<CheckBoxState>({
    men: false,
    women: false,
  });
  const { category } = useParams<{ category: string }>();

  useEffect(() => {
    const resetCheckBoxState: CheckBoxState = {
      men: false,
      women: false,
    };
    if (category === "all") {
      setCheckBoxState(resetCheckBoxState);
      return;
    }
    setCheckBoxState({ ...resetCheckBoxState, [category]: true });
  }, [category]);

  useEffect(() => {
    async function getData() {
      const res = await fetchFromApi<Product[]>("products");
      
      function getFilteredData() {
        if (!checkBoxState.men && !checkBoxState.women) {
          return res.filter(product =>
            product.category === "men's clothing" ||
            product.category === "women's clothing"
          );
        }

        return res.filter(product => {
          if (checkBoxState.men && product.category === "men's clothing") {
            return true;
          } else if (checkBoxState.women && product.category === "women's clothing") {
            return true;
          }
          return false;
        });
      }

      setProducts(getFilteredData());
      setPriceFilter("default");
    }
    getData();
  }, [checkBoxState]);

  function handleCategoryCheckBox(e: React.ChangeEvent<HTMLInputElement>) {
    const { name, checked } = e.target;
    setCheckBoxState(prevState => ({ ...prevState, [name]: checked }));
  }

  function handlePriceFilter(e: React.ChangeEvent<HTMLSelectElement>) {
    const filter = e.target.value;
    if (filter === "low-to-high") {
      setProducts(prevProducts => 
        [...prevProducts].sort((a, b) => a.price - b.price)
      );
    } else if (filter === "high-to-low") {
      setProducts(prevProducts => 
        [...prevProducts].sort((a, b) => b.price - a.price)
      );
    }
    setPriceFilter(filter);
  }

  return (
    <main className="product-main">
      <PriceFilter priceFilter={priceFilter} handlePriceFilter={handlePriceFilter} />
      <SelectCategory checkBoxState={checkBoxState} handleCheckBox={handleCategoryCheckBox} />
      <div className="products-container">
        <AllProducts products={products} />
      </div>
    </main>
  );
}

interface AllProductsProps {
  products: Product[];
}

function AllProducts({ products }: AllProductsProps) {
  return products.length ? (
    products.map(product => <ProductCard product={product} key={product.id} />)
  ) : (
    <Skeleton />
  );
}

function Skeleton() {
  return Array.from({ length: 4 }, (_, i) => <Shimmer key={i} />);
}

export default ExploreProduct;
