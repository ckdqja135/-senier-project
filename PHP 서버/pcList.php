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
              FROM  tbl_pp_pc";
    
   $lo_stid = mysqli_query($conn, $sql);
   if (mysqli_num_rows($lo_stid) > 0) {
        while(( $row = mysqli_fetch_array($lo_stid) )){
            $lo_resultData = array("pc_no"       => $row['pc_no'],
                                   "pc_name"     => $row['pc_name'],
                              	   "pc_tel"      => $row['pc_tel'],
                          	   	   "pc_address"  => $row['pc_address'],
                          	   	   "pc_info"     => $row['pc_info'],
                          	   	   "pc_profile"  => $row['pc_profile'],
                          	   	   "location_no" => $row['location_no'],
                          	   	   "total_seat"  => $row['total_seat'],
                          	   	   "use_seat"    => $row['use_seat'],
                                   "latitude"    => $row['latitude'],
                                   "longitude"   => $row['longitude']
                              	);

            array_push($arrO_result, $lo_resultData);
        }
        
        $o_data['success'] = true;
        $o_data['list']    = $arrO_result;
    }
    else {
        $o_data['success'] = false;
    }
   
    echo json_encode($o_data);
?>