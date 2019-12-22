function deleteAllSwits() {
    $.ajax({
        url: "/rest/swits",
        type: "DELETE",
    });
}

function deleteSwitById(id) {
    $.ajax({
        url: "/rest/" + id + "/swit",
        type: "DELETE",
    });
    redirectToAllSwits();
}

function updateSwitById(id, content) {
    $.ajax({
        url: "/swit/" + id + "/update/save/",
        data: content,
        type: "PUT",
    });
}

function redirectToAllSwits(){
    window.location.replace("/swits");
}

