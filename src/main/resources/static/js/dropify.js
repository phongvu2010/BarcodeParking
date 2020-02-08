(function($) {
  'use strict';
  $('.dropify').dropify();

})(jQuery);

$(document).ready(function() {
  $("#uploadLogo").click(function(event) {
	// Stop default form Submit.
	event.preventDefault();

	// Call Ajax Submit.
	ajaxSubmitForm();
  });
});

function ajaxSubmitForm() {
  // Get form
  var form = $('#uploadForm')[0];
  var data = new FormData(form);

  $("#uploadLogo").prop("disabled", true);
  $.ajax({
	type: "POST",
	enctype: 'multipart/form-data',
	url: "/upload-file",
	data: data,

	// prevent jQuery from automatically transforming the data into a query string
	processData: false,
	contentType: false,
	cache: false,
	timeout: 1000000,
	success: function(data, textStatus, jqXHR) {
	  $("#result").html(data);
	  console.log("SUCCESS : ", data);
	  $("#uploadLogo").prop("disabled", false);
	  $('#uploadForm')[0].reset();
	},
	error: function(jqXHR, textStatus, errorThrown) {
	  $("#result").html(jqXHR.responseText);
	  console.log("ERROR : ", jqXHR.responseText);
	  $("#uploadLogo").prop("disabled", false);
	}
  });
}