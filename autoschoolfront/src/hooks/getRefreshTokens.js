import axios from "axios";

const getRefreshTokens = async () => {
    try {
        const response = await axios.get("http://localhost:8080/api/v1/refreshToken", {withCredentials: true});
        if (response.status === 200) {
            return true;
        }else{
            return false;
        }
    }catch (error){
        return false;
    }
}

export default getRefreshTokens;