import express from 'express';
import {Express} from 'express'


const app:Express = express();
app.use(express.static(__dirname + '/pages/'));

const port = 3000

app.get('/', (req:any, res:any) => {
  res.send('Hello World!')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})