function addNewTransaction(){
    $.confirm({
        title: 'Add new transaction',
        content: '<form action="/domain/transactions/insert" method="post">' +
        '<div class="form-group">'+
        '<label>Transaction Type:</label>'+
        ' <input type="number" class="form-control" name="TXN_TYPE" placeholder="Transaction Type">'+
        ' </div>'+
        '<div class="form-group">'+
        '<label>PAN</label>' +
        '<input type="text" class="form-control" name="PAN" placeholder="PAN">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>Acquirer BIN</label>' +
        '<input type="text" class="form-control" name="ACQ_BIN" placeholder="Acquirer BIN">' +
        '</div>'+
        '</div>'+
        '<div class="form-group">' +
        ' <label>Transaction online date</label>' +
        '<input type="date" class="form-control" name="TXN_ONLINE_DATE" placeholder="Transaction online date">' +
        '</div>'+
        '<div class="form-group">' +
        ' <label>Transaction amount</label>' +
        '<input type="number" class="form-control" name="TXN_AMOUNT" placeholder="Transaction amount">' +
        '</div>'+
        '<div class="form-group">' +
        ' <label>Transaction currency</label>' +
        '<input type="text" class="form-control" name="TXN_CURRENCY" placeholder="Transaction currency">' +
        '</div>'+
        '<div class="form-group">' +
        ' <label>File</label>' +
        '<input type="number" class="form-control" name="FILE_ID" placeholder="FILE ID">' +
        '</div>'+
        '<button style="float: right" type="submit" class="btn btn-success" style="float:right">Add transation</button>' +
        '</form>',

        cancel: function(){

        }
    });
}

function addNewFile() {
    $.confirm({
        title: 'Add new file',
        content: '<form action="/domain/files/insert" method="post">' +
        '<div class="form-group">'+
        '<label>File name</label>'+
        ' <input type="text" class="form-control" name="FILE_NAME" placeholder="File name">'+
        ' </div>'+
        '<div class="form-group">'+
        '<label>File size</label>' +
        '<input type="number" class="form-control" name="FILE_SIZE" placeholder="File size">' +
        '</div>' +
        '<div class="form-group">' +
        ' <label>Import date</label>' +
        '<input type="date" class="form-control" name="IMPORT_DATE" placeholder="Import date">' +
        '</div>'+
        '<button style="float: right" type="submit" class="btn btn-success" style="float:right">Add interest</button>' +
        '</form>',

        cancel: function(){

        }
    });
}