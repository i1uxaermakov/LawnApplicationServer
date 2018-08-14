function send(r){
    r.preventDefault();
    $.ajax({ 
        type: 'POST', 
        url: '',
        data: '',
        success: function(comms) { 
            
        }
    });
}
$(document).ready(function () {
    send();
});