<?php
 
// �⺻ Ÿ���� ����
date_default_timezone_set('Asia/Seoul');
 
// �����ͺ��̽� �׽�Ʈ
$mysqli = new mysqli('localhost', 'root', 'jsjs123', 'pocket_pc');
if ($mysqli->connect_errno) {
    die('Connection Error ('.$mysqli->connect_errno.'): '.
    $mysqli->connect_error);
}
 
// PHP ���� ���
phpinfo();