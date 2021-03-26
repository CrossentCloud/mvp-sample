import {Server} from "../app";


const port = 3000;
const app= new Server().app;
app.set('port',port);
app.listen(app.get('port'),()=>{
    console.log(app.get('port') + 'server is Running');
}).on('error',err => {
    console.log('Error message ' + err);

})