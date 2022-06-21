#!/system/bin/sh
MODDIR=${0%/*}

/system/bin/app_process -Djava.class.path=$MODDIR/classes.dex /system/bin com.rosan.service.Entry $MODDIR/address

for file in $(ls $MODDIR/../*/r-unlocked.sh)
do
	echo $file
	sh $file &
done
