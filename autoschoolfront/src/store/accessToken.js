import { createSlice } from '@reduxjs/toolkit'

export const accessToken = createSlice({
    name: 'accessToken',
    initialState:{
        value: "",
    },
    reducers:{
        setToken:(state, action)=>{
            state.value = action.payload;
        },
    }
});

export const { setToken } = accessToken.actions;
export const selectAccess = (state) => state.counter.value;

export default accessToken.reducer;