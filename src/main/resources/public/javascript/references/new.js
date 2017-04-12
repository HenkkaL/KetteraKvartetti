$(document).ready(function() {
    setVisibleAttributes();

    $("#type").change(function() {
        setVisibleAttributes();
    });
    
    $("input").focus(function() {
        this.setCustomValidity("");
    });
    
    $("form").submit(function(event) {
        var selectedType = $("#type").val();
        
        if (selectedType === "article" || selectedType === "inproceedings") {
            pagesOk = checkPages(selectedType);
            console.log(pagesOk);
            if (!pagesOk) {
                $("#" + selectedType + "_pages_start")[0].setCustomValidity("Tarkista sivunumerot.");
                $("#" + selectedType + "_pages_end")[0].setCustomValidity("Tarkista sivunumerot.");
                event.preventDefault();
            } else {
                $("#" + selectedType + "_pages_start")[0].setCustomValidity("");
                $("#" + selectedType + "_pages_end")[0].setCustomValidity("");
            }
        }
    });
});

function setVisibleAttributes() {
    var selectedType = $("#type").val();
    
    switch(selectedType) {
        case "book":
            showHideHide("#book_attributes", "#article_attributes", "#inproceedings_attributes");
            break;
        case "inproceedings":
            showHideHide("#inproceedings_attributes", "#article_attributes", "#book_attributes");
            break;
        case "article":
            showHideHide("#article_attributes", "#inproceedings_attributes", "#book_attributes");
            break;
    }
};

function showHideHide(showThis, hideThis, hideThisAsWell) {
    $(showThis).show();
    $(hideThis).hide();
    $(hideThisAsWell).hide();
    setRequiredFields($(showThis).find("input.required_input"), true);
    setRequiredFields($(hideThis).find("input.required_input"), false);
    setRequiredFields($(hideThisAsWell).find("input.required_input"), false);
    emptyFields($(hideThis).find("input"));
    emptyFields($(hideThisAsWell).find("input"));
};

function setRequiredFields(fields, isRequired) {
    $.each(fields, function(key, val) {
        val.required = isRequired;
    });
};

function emptyFields(fields) {
    $.each(fields, function(key, val) {
        val.value = "";
    });
};

function checkPages(referenceType) {
    var pagesStart = $("#" + referenceType + "_pages_start").val();
    var pagesEnd = $("#" + referenceType + "_pages_end").val();
    var check = true;
    if (pagesStart.length > 0 && pagesEnd.length === 0) {
        check = false;
    }
    if (pagesStart.length === 0 && pagesEnd.length > 0) {
        check = false;
    }
    if (pagesStart.length > 0 && pagesEnd.length > 0) {
        if (pagesStart > pagesEnd) {
            check = false;
        }
    }
    
    return check;
};