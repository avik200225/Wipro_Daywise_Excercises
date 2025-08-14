enum HttpStatusCode {
    OK = 200,
    NOTFOUND = 404,
    ACCESSDENIED = 403,
    INTERNALERROR = 500
}

console.log("OK:",HttpStatusCode.OK);           
console.log("NOTFOUND",HttpStatusCode.NOTFOUND);     
console.log("ACCESSDENIED",HttpStatusCode.ACCESSDENIED); 
console.log("INTERNALERROR",HttpStatusCode.INTERNALERROR);
