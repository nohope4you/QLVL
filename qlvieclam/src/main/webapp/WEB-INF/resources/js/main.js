function delJob(path,id){
    fetch(path,{
        method:"delete"
        
    }).then(res=>{
        if(res.status==204)
            location.reload();
        else 
            alert("ERROR");
    })
}
