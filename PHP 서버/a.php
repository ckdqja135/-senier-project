<?php
 
// 기본 타임존 설정
date_default_timezone_set('Asia/Seoul');
 
// 데이터베이스 테스트
$mysqli = new mysqli('localhost', 'root', 'jsjs123', 'pocket_pc');
if ($mysqli->connect_errno) {
    die('Connection Error ('.$mysqli->connect_errno.'): '.
    $mysqli->connect_error);
}
 
// PHP 정보 출력
phpinfo();