import cookie from "react-cookies";

const MyJobReducer = (currentState, action) => {
    switch (action.type) {
        case "inc":
            return action.payload;
        case "dec":
            cookie.remove("savecookie");
            return null;
    }

    return currentState;
}

export default MyJobReducer;