function answer(name, a1, a2, a3, a4, a5) {
    this.name = name;
    this.a1 = a1;
    this.a2 = a2;
    this.a3 = a3;
    this.a4 = a4;
    this.a5 = a5;
}

function download(content, fileName, contentType) {
    var a = document.createElement("a");
    var file = new Blob([content], {type: contentType});
    a.href = URL.createObjectURL(file);
    a.download = fileName;
    a.click();
}

function send() {
    let jsonData = JSON.stringify(new answer(
        $("#name").val(),
        $("#a1").val(),
        $("#a2").val(),
        $("#a3").val(),
        $("#a4").val(),
        $("#a5").val()
    ));
    download(jsonData, 'result.json', 'text/plain');
}