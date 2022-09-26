import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { PostListPage } from "pages/Post";
import Header from "components/Header";

function App() {
  return (
    <div className="App">
      <Header />
      <BrowserRouter>
        <Routes>
          <Route path="/post" element={<PostListPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
