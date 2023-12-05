import HomePage from "./pages/HomePage";
import HouseDetails from "./pages/HouseDetails";
import Login from "./pages/Login";



const AppRoutes = [
    {
        index: true,
        path: '/',
        element: <Login/>
    },
    {
        path: '/home',
        element: <HomePage/>
    },
    {
        path: '/houseDetails',
        element: <HouseDetails/>
    }    


];

export default AppRoutes;