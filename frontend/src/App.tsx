import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { PostListPage } from "pages/Post";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>

      <BrowserRouter>
        <Routes>
          <Route path="/post" element={<PostListPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
