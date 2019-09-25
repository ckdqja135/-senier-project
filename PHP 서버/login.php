<?php
    function mysqli_result($res,$row=0,$col=0)
    { 
      $nums=mysqli_num_rows($res);
      if($nums && $row<=($nums-1) && $row>=0)
      {
        mysqli_data_seek($res,$row);
        $resrow=(is_numeric($col))?mysqli_fetch_row($res):mysqli_fetch_assoc($res);
        if(isset($resrow[$col]))
        {
          return $resrow[$col];
        }
      }
      return false;
    }
    
    $arrO_result       = array();
    $o_data['success'] = false;
        
    $conn = mysqli_connect(
    'localhost',
    'root',
    'jsjs123',
    'pocket_pc');
      
    $sql = "SELECT  user_no,  
    			    user_name,  
    			    user_id  
              FROM  tbl_pp_user 
             WHERE  user_id = '".$_POST['id']."' AND
             	    user_pw = '".$_POST['pw']."'";

   $lo_stid = mysqli_query($conn, $sql)


   if (mysqli_num_rows($lo_stid) > 0) {
        while(( $row = mysqli_fetch_array($lo_stid) )){
            $lo_resultData = array("user_no"   => $row['user_no']
                                  ,"user_name" => $row['user_name']
                              	  ,"user_id"   => $row['user_id']);
            

            array_push($arrO_result, $lo_resultData);
        }
        
        $o_data['success'] = true;
        $o_data['mode']    = "login";
        $o_data['list']    = $arrO_result;
    }
    else {
        $o_data['success'] = false;
    }
   
    echo json_encode($o_data);
?>