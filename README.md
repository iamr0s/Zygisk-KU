# KeyguardUnlocked

基于[Zygisk](https://github.com/topjohnwu/zygisk-module-sample)的[Magisk](https://topjohnwu.github.io/Magisk/guides.html)模块。

用于监听第一次开屏解锁事件。

## 用途

[加密](https://source.android.com/security/encryption)是指使用对称加密密钥对 Android 设备上的所有用户数据进行编码的过程。

[文件级加密](https://source.android.com/security/encryption/file-based)是Android 7.0引入的功能，Google借此实现了一项称为[直接启动](https://developer.android.com/training/articles/direct-boot)的新功能。

`直接启动`开启后，系统分为两个存储位置。
* 凭据加密存储
* 设备加密存储

在你未输入密码前，`凭据加密存储位置`将会处于加密状态。

通俗的理解为：如果开启了`直接启动`，Android设备开机过程中会进行部分解密，即解密`设备加密存储位置`。此时的`凭据加密存储位置`仍然是处于加密状态，直到你输入密码，进入系统。

如果你需要通过Magisk执行某些操作，这些操作涉及到以下文件夹下的文件时，需要处于`凭据加密存储位置`解密后。
* /data/data
* /data/app
* /storage/emulated/0
* ......

## 需要

* Magisk v24.3版本及以上
* Zygisk已启动

