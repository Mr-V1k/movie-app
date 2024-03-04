import './App.css';
import api from './api/axios_config';
import {useState, useEffect} from 'react';
import { Layout } from './Components/Layout';
import { Routes, Route } from 'react-router-dom';
import { Home } from './Components/home/Home';
import { Header } from './Components/header/Header';
import { Trailer } from './Components/trailer/Trailer';
import { Review } from './Components/review/review';
import { NotFound } from './Components/notfound/NotFound';

function App() {
  
  const [movies, setMovies] = useState();
  const [movie, setMovie] = useState();
  const [reviews, setReviews] = useState()

  const getMovies = async () => {
    try{
      const response = await api.get("/movie");
      setMovies(response.data);
      console.log(movies);
    }catch(err){
      console.log("Error getting data from api: " + err);
    }
  }

  useEffect(() => {
    getMovies();
  }, []);

  const getMovieData = async (movieId) => {
    try{
      const response = await api.get(`/movie/${movieId}`);
      const singleMovie = response.data;
      setMovie(singleMovie);
      setReviews(singleMovie.reviewIds);
    }catch(err){
      console.log(err);
    }
  }

  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home movies={movies} />}></Route>
          <Route path="/Trailer/:ytTrailerId" element={<Trailer />}></Route>
          <Route path="/Reviews/:movieId" element={
            <Review 
              getMovieData={getMovieData}
              movie={movie}
              reviews={reviews}
              setReviews={setReviews}
            />} />
          <Route path="*" element={<NotFound />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
