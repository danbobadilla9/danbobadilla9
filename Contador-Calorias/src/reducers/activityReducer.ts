import { Activity } from "../types"

// describe que haces en el activityReducer
export type ActitivyActions = {
    type: 'save-activity',payload: {newActivity : Activity}
}


type ActivityState = {
    activities: Activity[]
}

export const initialState: ActivityState = {
    activities: []
}


export const activityReducer = (
    state: ActivityState = initialState,
    action: ActitivyActions
) => {
    if(action.type === 'save-activity'){
        // Maneja la logica par actualizar el state 
        
    }
}