import HomePage from "./pages/HomePage";
import HouseDetails from "./pages/HouseDetails";
import Login from "./pages/Login";
import TenantProfile from "./pages/TenantProfile";
import SelectAgent from "./pages/SelectAgent";
import LandlordProfile from "./pages/LandlordProfile";
import RealEstateAgentProfile from "./pages/RealEstateAgentProfile";
import StateOfficialProfile from "./pages/StateOfficialProfile";
import LandlordNotification from "./pages/LandlordNotificaiton";
import RealEstateAgentNotification from "./pages/RealEstateAgentNotificaiton";
import StateOfficialNotification from "./pages/StateOfficialNotification";
import HandledComplaints from "./pages/HandledComplaints";
import PendingComplaints from "./pages/PendingComplaints";
import Contracts from "./pages/Contracts";
import ApprovedContracts from "./pages/ApprovedContracts";
import LandlordPastRequest from "./pages/LandlordPastRequest";
import LandlordCurrentRequest from "./pages/LandlordCurrentRequest";
import RealEstateAgentPastRequest from "./pages/RealEstateAgentPastRequest";
import RealEstateAgentCurrentRequest from "./pages/RealEstateAgentCurrentRequest";
import SeeTenantProfile from "./pages/SeeTenantProfile";
import SeeLandlordProfile from "./pages/SeeLandlordProfile";
import SeeRealEstateAgentProfile from "./pages/SeeRealEstateAgentProfile";
import SeeTenantAndLandlord from "./pages/SeeTenantAndLandlord";
import SeeTenantAndRealEstateAgent from "./pages/SeeTenantAndRealEstateAgent";
import Signup from "./pages/Signup";
import ForgotPassword from "./pages/ForgotPassword";
import PublishAd from "./pages/PublishAd";
import RealEstateAgentHomePage from "./pages/RealEstateAgentHomePage";
import StateOfficialHomePage from "./pages/StateOfficialHomePage";



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
        path: '/landlordProfile',
        element: <LandlordProfile/>
    },   
    {
        path: '/realEstateAgentProfile',
        element: <RealEstateAgentProfile/>
    },     
    {
        path: '/stateOfficialProfile',
        element: <StateOfficialProfile/>
    },
    {
        path: '/landlordNotification',
        element: <LandlordNotification/>
    },    
    {
        path: '/realEstateAgentNotification',
        element: <RealEstateAgentNotification/>
    }, 
    {
        path: '/stateOfficialNotification',
        element: <StateOfficialNotification/>
    }, 
    {
        path: '/handledComplaints',
        element: <HandledComplaints/>
    },
    {
        path: '/pendingComplaints',
        element: <PendingComplaints/>
    },  
    {
        path: '/contracts',
        element: <Contracts/>
    },            
    {
        path: '/approvedContracts',
        element: <ApprovedContracts/>
    },
    {
        path: '/landlordPastRequest',
        element: <LandlordPastRequest/>
    },
    {
        path: '/landlordCurrentRequest',
        element: <LandlordCurrentRequest/>
    },
    {
        path: '/realEstateAgentPastRequest',
        element: <RealEstateAgentPastRequest/>
    },
    {
        path: '/realEstateAgentCurrentRequest',
        element: <RealEstateAgentCurrentRequest/>
    },
    {
        path: '/seeTenantProfile',
        element: <SeeTenantProfile/>
    },
    {
        path: '/seeLandlordProfile',
        element: <SeeLandlordProfile/>
    },
    {
        path: '/seeRealEstateAgentProfile',
        element: <SeeRealEstateAgentProfile/>
    },
    {
        path: '/seeTenantAndLandlord',
        element: <SeeTenantAndLandlord/>
    },
    {
        path: '/seeTenantAndRealEstateAgent',
        element: <SeeTenantAndRealEstateAgent/>
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
    {
        path: '/realestateagenthome',
        element: <RealEstateAgentHomePage/>
    },    
    {
        path: '/stateofficialhome',
        element: <StateOfficialHomePage/>
    },    
];

export default AppRoutes;