$(function() {
		$('#tasksTable td .text-time').click(function() {
			
			var cur_td = $(this)[0];

			var nowTime = new Date($.now());

			var nowHour = nowTime.getHours();
			if (nowHour < 10) {
				nowHour = "0" + nowHour;
			}

			var nowMinutes = nowTime.getMinutes();
			if (nowMinutes < 10) {
				nowMinutes = "0" + nowMinutes;
			}

			$(cur_td).val(nowHour + ":" + nowMinutes);
		}); // click()
		
		$('.status-button').click(function() {
			var nowTime = new Date($.now());

			var nowHour = nowTime.getHours();
			if (nowHour < 10) {
				nowHour = "0" + nowHour;
			}

			var nowMinutes = nowTime.getMinutes();
			if (nowMinutes < 10) {
				nowMinutes = "0" + nowMinutes;
			}
			
			if($(this).hasClass('status-start')) {				
				$(this).closest('tr').children('td').children('.start-time').val(nowHour + ":" + nowMinutes);
				$(this).addClass('status-mid');
				$(this).removeClass('status-start');
				$(this).text("途中");
			} else if ($(this).hasClass('status-mid')) {
				$(this).closest('tr').children('td').children('.end-time').val(nowHour + ":" + nowMinutes);
				$(this).removeClass('status-mid');
				$(this).text("完了");
				$(this).prop('disabled', true);
			}

		}); // click()
		
		$('.end-button').click(function() {
			var nowTime = new Date($.now());

			var nowHour = nowTime.getHours();
			if (nowHour < 10) {
				nowHour = "0" + nowHour;
			}

			var nowMinutes = nowTime.getMinutes();
			if (nowMinutes < 10) {
				nowMinutes = "0" + nowMinutes;
			}
			
			$(this).closest('tr').children('td').children('.end-time').val(nowHour + ":" + nowMinutes);
			$(this).removeClass('end-button');
			$(this).val("完了");
		}); // click()
		
		$('#tasksTable td .record-time').click(function() {
			var startTime = $(this).closest('tr').children('td').children('.start-time').val();
			var startTimeArray = startTime.toString().split(":"); 
			var startTimeHour = parseInt(startTimeArray[0], 10);
			var startTimeMinute = parseInt(startTimeArray[1], 10);
			
			var endTime = $(this).closest('tr').children('td').children('.end-time').val();
			var endTimeArray = endTime.toString().split(":"); 
			var endTimeHour = parseInt(endTimeArray[0], 10);
			var endTimeMinute = parseInt(endTimeArray[1], 10);
			
			var diffHour = endTimeHour - startTimeHour;
			var diffMinute = endTimeMinute - startTimeMinute;
			
			if(diffMinute < 0) {
				diffHour = diffHour - 1;
				diffMinute = 60 + diffMinute;
			}
			
			$(this).val(diffHour + ":" + diffMinute);
			
			
		}); // change()
		
//
//		$('#button-end').on(
//				'click',
//				function() {
//
//					var nowTime = new Date($.now());
//
//					var nowHour = nowTime.getHours();
//					if (nowHour < 10) {
//						nowHour = "0" + nowHour;
//					}
//
//					var nowMinutes = nowTime.getMinutes();
//					if (nowMinutes < 10) {
//						nowMinutes = "0" + nowMinutes;
//					}
//					$('#text-end').val(
//							nowTime.getHours() + ":" + nowTime.getMinutes());
//				}); // on()
		
}); // ready()
