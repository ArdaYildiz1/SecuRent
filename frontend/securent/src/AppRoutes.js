import HomePage from "./pages/HomePage";
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
    }


];

export default AppRoutes;