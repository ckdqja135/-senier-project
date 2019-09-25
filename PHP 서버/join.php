<?php
	$conn = new mysqli("localhost", "root", "jsjs123", "pocket_pc");
    
	if ($conn->connect_errno) {
	    printf("Connect failed: %s\n", $conn->connect_error);
	    exit();
	}

    $arrO_result       = array();
    $o_data['success'] = false;
      

    if(empty($_POST['id'] || empty($_POST['pw']))){
    	$o_data['success'] = false;
		$o_data['message'] = "아이디 또는 비밀번호 누락";
		echo json_encode($o_data);
		exit();
    }

    $sql = "select user_no 
    		  from tbl_pp_user 
    		 where user_id = '".$_POST['id']."'";

	$lo_stid = mysqli_query($conn, $sql);	 

	if(mysqli_num_rows($lo_stid) > 0){
		$o_data['success'] = false;
		$o_data['message'] = "아이디 중복";
		echo json_encode($o_data);
	} else {
		$sql = "insert into tbl_pp_user (user_name, user_id, user_pw, user_phone) 
			         values ('1234', '".$_POST['id']."', '".$_POST['pw']."', '010-0000-000')";

		$conn->query($sql);

	    $o_data['success'] = true;
	    $o_data['message'] = "가입 성공";
	    echo json_encode($o_data);
	}
?>