function deleteAllSwits() {
    $.ajax({
        url: "/swits",
        type: "DELETE",
    });
    redirectToAllSwits();
}

function deleteSwitById(id) {
    let switId = id;
    $.ajax({
        url: "/swit/" + switId,
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

function redirectToAllSwits() {
    window.location.replace("/swits");
}

