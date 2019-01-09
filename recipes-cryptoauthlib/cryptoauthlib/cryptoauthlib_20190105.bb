SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe for CryptoAuthLib https://github.com/MicrochipTech/cryptoauthlib"
LICENSE = "MIT"

SRCREV = "2044ad999eb288ef9c70b52bd15d54464a0a6a3c"
SRC_URI = "git://github.com/MicrochipTech/cryptoauthlib.git"

LIC_FILES_CHKSUM = "file://../license.txt;md5=b5b48730d6f3c3c31c53274314051b47"

inherit cmake pkgconfig

S = "${WORKDIR}/git/lib"

do_install() {
	cd ${WORKDIR}/git/python
	cp -r ../third_party .
	cp -r ../lib .
	#python setup.py sdist --dist-dir 
    #install -d ${D}/lib/${bindir}
}

SRC_URI[md5sum] = "ac317fa31493d2848ad7b35cbae9ce31"
SRC_URI[sha256sum] = "da1d45faf327d3328257de5588c42065b235c2eea19b729eb1bd7d6a297918bc"

DEPENDS = "udev"
