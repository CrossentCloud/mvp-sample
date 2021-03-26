import express from 'express';


export class Server {
    constructor(){
        this.app=express();
        this.app.get('/',(req,res)=>{
            res.send('This is Node Server. Hello World.');
        })
    }
}