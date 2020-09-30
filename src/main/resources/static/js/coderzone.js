


function post(){
    var questionId =$("#question_id").val();
    var content = $("#comment-content").val();
    if (!content){
        alert("Reply cannot be empty");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType:"application/json",
        data: JSON.stringify({
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        success: function (response){
            if (response.code == 200){
                window.location.reload();
            } else if (response.code == 2003){
                var isAccepted = confirm(response.message);
                if (isAccepted){
                    window.open("https://github.com/login/oauth/authorize?client_id=e8e7f530973f2ab0fcf3&redirect_uri=http://localhost:8886/callback&scope=user&state=1");
                    window.localStorage.setItem("closable",true);

                }
            } else {
                alert(response.message);
            }
            console.log(response);
        },
        dataType: "json"
    });
}