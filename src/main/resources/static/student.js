// hiê thị du lieu
const showAllStudents= ()=>{
    // lấy du liệu
    // call api
    fetch('http://localhost:8080/api.example.com/students')
        .then(res=> res.json())
        .then(res => console.log("data",res))
        .catch(err=>console.log("err",err))

}
showAllStudents();