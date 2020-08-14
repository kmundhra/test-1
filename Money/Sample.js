"use strict";
function mR(location){
    return new Promise((resolve,reject) => {
        console.log(`Making request to ${location}`)
    if(location=="Google"){
        resolve(`Google says hi`)
    }
    else{
        reject("We can only talk to google")
    }
    })
}
function pR(response){
    return new Promise((resolve,reject) => {
        console.log("Processing response")
        resolve(`Extra Info+ ${response}`)
    }
    )
}
async function doWork() {
    try{
        const response = mR("Google")
        console.log("Response Received")
        const processedResponse = pR(response)
        console.log(processedResponse)
    }catch(err){
        console.log(err)
    }
}
doWork()