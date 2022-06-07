SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe for CryptoAuthLib https://github.com/MicrochipTech/cryptoauthlib"
LICENSE = "MIT"

PV = "20211006"

SRCREV = "055dd4afafb019db1f4d61880aa441832139faa2"
SRC_URI = "git://github.com/MicrochipTech/cryptoauthlib.git;branch=main"
SRC_URI[md5sum] = "00f3be6f53202117cb514ccfb7142e0a"
SRC_URI[sha256sum] = "ee8ee192cf7e2f105808aa634e1f9b422c8227d40a457d11202db7fea1d17d17"

LIC_FILES_CHKSUM = "file://../license.txt;md5=2b56c229b6ececc3a14d533a1d70029b"

DEPENDS += "udev"

S = "${WORKDIR}/git/lib"

EXTRA_OECMAKE += "-DATCA_HAL_I2C=on -DATCA_PKCS11=on -DDEFAULT_LIB_PATH=/usr/lib"

inherit cmake

do_install() {
    install -d ${D}/usr/lib
    install -m 0755 ${WORKDIR}/build/libcryptoauth.so ${D}/usr/lib
}

FILES_${PN} = "/usr/lib/libcryptoauth.so"
FILES_${PN}-dev = ""
