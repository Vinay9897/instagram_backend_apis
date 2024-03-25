import { Grid } from "@mui/material"
import SideBar from "../../components/SideBar"
import {useLocation,Route,Routes} from "react-router-dom"
import Middle from "../../components/MiddlePart/MiddlePart.jsx"
import Reels from "../../components/Reels/Reels.jsx"
import CreateReelsForm from "../../components/Reels/CreateReelsForm.jsx"
import Profile from "../../components/Profile/Profile.jsx"
 

const HomePage = () => {
    const location = useLocation();
    return(
        <div className="px-20">
            <Grid container spacing={0}>
                <Grid item xs = {0} lg={3}>
                    <div className="sticky top-0">
                        <SideBar/>

                    </div>
                </Grid>
                <Grid lg ={location.pathname==="/"?6:9} item className="px-5 flex justify-center" xs={12}>
                    <Routes>
                        <Route path="/" element = {<Middle/>} />
                        <Route path="/reels" element = {<Reels/>} />
                        <Route path="/create-reels" element={<CreateReelsForm/>}></Route>
                        <Route path="/profile/:id" element = {<Profile/>} />
                    </Routes>
                </Grid>
            </Grid>
        </div>
    );
}

export default HomePage;