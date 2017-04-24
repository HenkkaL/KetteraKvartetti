var AUTHOR_ID = 1;
var TAG_ID = 0;

$(document).ready(function() {
    setVisibleAttributes();

    $("#type").change(function() {
        setVisibleAttributes();
    });
    
    $("input").focus(function() {
        this.setCustomValidity("");
    });
    
    $("#input_tag").on('input', function() {
        console.log("change");
        console.log($(this).val());
        var inputLen = $(this).val().length;
        if (inputLen > 0) {
            $("#add_tag_button").prop("disabled", false);
        } else {
            $("#add_tag_button").prop("disabled", true);
        }
    });
    
    $("form").submit(function(event) {
        var selectedType = $("#type").val();
        
        if (selectedType === "article" || selectedType === "inproceedings") {
            var pagesOk = checkPages(selectedType);
            if (!pagesOk) {
                $("#pages_start")[0].setCustomValidity("Tarkista sivunumerot.");
                $("#pages_end")[0].setCustomValidity("Tarkista sivunumerot.");
                event.preventDefault();
            } else {
                $("#pages_start")[0].setCustomValidity("");
                $("#pages_end")[0].setCustomValidity("");
            }
        }
    });
});

function addTag() {
    TAG_ID++;
    var tagId = "tag" + TAG_ID;
    var li = createElement("li").text($("#input_tag").val());
    var input = createElement("input");
    input.attr("value", $("#input_tag").val());
    input.attr("id", tagId);
    $("#tag_list").append(li);
    $("#tag_inputs").append(input);
    $("#input_tag").val("");
    $("#add_tag_button").prop("disabled", true);
}

function addAuthorField() {
    var authorTable = $("#author_table");
    var newAuthorRow = createNewAuthorRow();
    authorTable.append(newAuthorRow);
};

function createNewAuthorRow() {
    AUTHOR_ID++;
    var inputId = "author" + AUTHOR_ID;
    var tr = createElement("tr");
    var labelTd = createElement("td");
    var label = createElement("label").text("Tekijä " + AUTHOR_ID);
    label.attr("for", inputId);
    var inputTd = createElement("td");
    var input = createElement("input");
    input.attr("id", inputId);
    input.attr("name", inputId);
    input.attr("type", "text");
    inputTd.append(input);
    labelTd.append(label);
    tr.append(labelTd);
    tr.append(inputTd);
    return tr;
}

function createElement(elementType) {
    return $("<" + elementType + "></" + elementType + ">");
}

function setVisibleAttributes() {
    var selectedType = $("#type").val();
    
    switch(selectedType) {
        case "book":
            showHideHide(".book_attr", ".article_attr", ".inproc_attr");
            setRequiredAttrs(".book_req", ".article_req", ".inproc_req");
            break;
        case "inproceedings":
            showHideHide(".inproc_attr", ".article_attr", ".book_attr");
            setRequiredAttrs(".inproc_req", ".article_req", ".book_req");
            break;
        case "article":
            showHideHide(".article_attr", ".inproc_attr", ".book_attr");
            setRequiredAttrs(".article_req", ".inproc_req", ".book_req");
            break;
    }
};

function showHideHide(showThis, hideThis, hideThisAsWell) {
    $(hideThis).each(function() {
        $(this).hide();
    });
    $(hideThisAsWell).each(function() {
        $(this).hide();
    });
    $(showThis).each(function() {
        $(this).show();
    });
};

function setRequiredFields(fields, isRequired) {
    $.each(fields, function(key, val) {
        val.required = isRequired;
    });
};

function setRequiredAttrs(req, notReq, notReqEither) {
    setInputs(req, notReq, notReqEither);
    setLabels(req, notReq, notReqEither);
};

function setInputs(req, notReq, notReqEither) {
    $("input" + notReq).each(function() {
        $(this).prop('required', false);
    });
    $("input" + notReqEither).each(function() {
        $(this).prop('required', false);
    });
    $("input" + req).each(function() {
        $(this).prop('required', true);
    });
};

function setLabels(req, notReq, notReqEither) {
    $("label" + notReq).each(function() {
        $(this).css('font-weight', 'normal');
    });
    $("label" + notReqEither).each(function() {
        $(this).css('font-weight', 'normal');
    });
    $("label" + req).each(function() {
        $(this).css('font-weight', 'bold');
    });
};

function checkPages() {
    var pagesStart = $("#pages_start").val();
    var pagesEnd = $("#pages_end").val();
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