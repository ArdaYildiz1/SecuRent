import HomePage from "./pages/HomePage";
import HouseDetails from "./pages/HouseDetails";
import Login from "./pages/Login";
import TenantProfile from "./pages/TenantProfile";
import SelectAgent from "./pages/SelectAgent";


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
    },
    {
        path: '/selectAgent',
        element: <SelectAgent/>
    },
    {
        path: '/tenantProfile',
        element: <TenantProfile/>
    },    


];

export default AppRoutes;