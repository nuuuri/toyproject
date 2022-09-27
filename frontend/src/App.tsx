import "./App.css";
import { Route, Routes } from "react-router-dom";
import { PostListPage } from "pages/Post";
import Layout from "components/Layout";

function App() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path="/post" element={<PostListPage />} />
      </Route>
    </Routes>
  );
}

export default App;
