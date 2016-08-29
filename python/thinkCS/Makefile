#-------------------------------------------------------------------------------
#
#  How to Think Like a Computer Scientist: Learning with Python  2nd Edition
#
#  make - creates xhtml, latex, and pdf versions.
#  make xhtml - xhtml only.
#  make latex - latex only.
#  make pdf - latex and pdf versions.
#
#-------------------------------------------------------------------------------

build:	xhtml

clean:
	rm -rf *.tex *.html *.eps

xhtml:
	lore --config template=./resources/template.tpl *.lore

latex:
	lore --output latex --config section *.html
