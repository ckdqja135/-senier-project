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
      
    $sql = "SELECT  * 
              FROM  tbl_pp_joinpc 
             WHERE  user_no=".$_POST['user_no'];

    
   $lo_stid = mysqli_query($conn, $sql);
   if (mysqli_num_rows($lo_stid) > 0) {
        while(( $row = mysqli_fetch_array($lo_stid) )){
            $lo_resultData = array("join_no" => $row['join_no'],
                                   "user_no" => $row['user_no'],
                              	   "pc_no"   => $row['pc_no']
                              	);

            array_push($arrO_result, $lo_resultData);
        }
        
        $o_data['success'] = true;
        $o_data['list']    = $arrO_result;
    }
    else {
        $o_data['success'] = false;
    }
   
    $o_data['mode']    = "joinPcList";
    echo json_encode($o_data);
?>