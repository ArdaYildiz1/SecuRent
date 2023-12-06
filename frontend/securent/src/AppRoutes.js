import HomePage from "./pages/HomePage";
import HouseDetails from "./pages/HouseDetails";
import Login from "./pages/Login";
import TenantProfile from "./pages/TenantProfile";
import SelectAgent from "./pages/SelectAgent";
import Signup from "./pages/Signup";
import ForgotPassword from "./pages/ForgotPassword";
import PublishAd from "./pages/PublishAd";


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
    {
        path: '/signup',
        element: <Signup/>
    },    
    {
        path: '/forgotPassword',
        element: <ForgotPassword/>
    },    
    {
        path: '/publishAd',
        element: <PublishAd/>
    },    


];

export default AppRoutes;