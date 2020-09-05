function submitBook(){
    let elements = document.getElementById("booksForm").elements;
    let obj ={};
    console.log(elements)
    for(let i = 0 ; i < elements.length ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }
    console.log(obj.name)
    const req = new XMLHttpRequest();
    req.open("POST", "http://localhost:8080/createLibrary");
    req.onload = () => {
        if (req.status === 200 && req.readyState == 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log(req.status);
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify(
        {
            "name":obj.name
        }
        )
    );
}
