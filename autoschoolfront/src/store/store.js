import { configureStore } from '@reduxjs/toolkit';
import accessToken from "./accessToken";

export default configureStore({
    reducer: {
        counter: accessToken,
    },
})