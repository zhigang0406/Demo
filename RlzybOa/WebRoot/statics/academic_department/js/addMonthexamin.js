$(function(){
	$("#selectGrade").change(function() {
		
		var studentClassId = $("#selectGrade").val();
		if(studentClassId == null || studentClassId == ""){
			studentClassId = 1;
		}
		$.ajax({
			type:"post",//��������
			url:"jzb/getStudentByClassId?studentClassId="+studentClassId,//�����url
			//data:{pid:studentClassId},//�������
			dataType:"json",//ajax�ӿڣ�����url�����ص���������
			success:function(data){//data���������ݣ�json����
			$("#addDailystatement").html("");
				var firstTr="<tr><th>ѧ��</th><th>����</th><th>����</th>"+
							"<th>����</th>";
				var table = "";
				for(var i = 0; i < data.length; i++){
					table += "<tr><td style=\"width: 200px;\">"
						+data[i].stu_number+"</td><td style=\"width: 200px;\">"
						+data[i].stu_name+"</td><td style=\"width: 200px;\"><input type=\"text\" class=\"textStyle yuxi1\" name=\"written\" style=\"width: 200px;border: none;\"></td><td style=\"width: 200px;\"><input type=\"text\" class=\"textStyle benshang1\" name=\"scjd\" style=\"width: 200px;border: none;\">"+
						"<input type=\"hidden\" name=\"studentId\" value='"+data[i].stu_Id+"' /></tr>";
									
				
				
				}
				$("#addDailystatement").html(firstTr+table);
			},
			error:function(data){//������ʱ��404��500 �ȷ�200�Ĵ���״̬��
				alert("�����ձ���ʧ��");
			}
		});
	});
});
