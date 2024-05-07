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
import StateOfficialNavBar from "./pages/StateOfficialNavBar";
import RealEstateAgentNavBar from "./pages/RealEstateAgentNavBar";
import TenantNavBar from "./pages/TenantNavBar";
import LandlordNavBar from "./pages/LandlordNavBar";
import RateRealEstateAgentForTenant from "./pages/RateRealEstateAgentForTenant";
import RateRealEstateAgentForLandlord from "./pages/RateRealEstateAgentForLandlord";
import AdminCreateStateOfficial from "./pages/AdminCreateStateOfficial";
import ListUsers from "./pages/ListUsers";
import AdminUpdateProfile from "./pages/AdminUpdateProfile";
import RentedHouse from "./pages/RentedHouse";
import RealEstateAgentHouseCondition from "./pages/RealEstateAgentHouseCondition";
import RealEstateAgentHouseConditionList from "./pages/RealEstateAgentHouseConditionList";
import ChoosedDeposit from "./pages/ChooseDeposit";
import RealEstateAgentHomePage from "./pages/RealEstateAgentHomePage";
import StateOfficialHomePage from "./pages/StateOfficialHomePage";
import RealEstateAgentHouseDetails from "./pages/RealEstateAgentHouseDetails";
import SeeTenantProfileFromAdmin from "./pages/SeeTenantProfileFromAdmin";
import StateOfficialHouseDetails from "./pages/StateOfficialHouseDetails";




const AppRoutes = [
    {
        path: '/login',
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
        path: '/stateOfficialNavBar',
        element: <StateOfficialNavBar/>
    }, 
    {
        path: '/realEstateAgentNavBar',
        element: <RealEstateAgentNavBar/>
    }, 
    {
        path: '/tenantNavBar',
        element: <TenantNavBar/>
    }, 
    {
        path: '/landlordNavBar',
        element: <LandlordNavBar/>
    },   
    {
        path: '/rateRealEstateAgentForTenant',
        element: <RateRealEstateAgentForTenant/>
    }, 
    {
        path: '/rateRealEstateAgentForLandlord',
        element: <RateRealEstateAgentForLandlord/>
    },  
    {
        path: '/AdminCreateStateOfficial',
        element: <AdminCreateStateOfficial/>
    },     
    {
        path: '/listUsers',
        element: <ListUsers/>
    },  
    {
        path: '/adminUpdateProfile',
        element: <AdminUpdateProfile/>
    },   
    {
        path: '/rentedHouse',
        element: <RentedHouse/>
    }, 
    {
        path: '/realEstateAgentHouseCondition',
        element: <RealEstateAgentHouseCondition/>
    }, 
    {
        path: '/realEstateAgentHouseConditionList',
        element: <RealEstateAgentHouseConditionList/>
    }, 
    {
        path: '/choosedDeposit',
        element: <ChoosedDeposit/>
    },   
    {
        path: '/realestateagenthome',
        element: <RealEstateAgentHomePage/>
    },    
    {
        path: '/stateofficialhome',
        element: <StateOfficialHomePage/>
    },    
    {
        path: '/realEstateAgentHouseDetails',
        element: <RealEstateAgentHouseDetails/>
    },    
    {
        path: '/seeTenantProfileFromAdmin',
        element: <SeeTenantProfileFromAdmin/>
    }, 
    {
        path: '/stateOfficialHouseDetails',
        element: <StateOfficialHouseDetails/>
    }, 
];

export default AppRoutes;