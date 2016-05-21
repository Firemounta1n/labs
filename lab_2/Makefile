TARGET=bin/*.class
BUILDDIR=bin
SOURCEDIR=src

all: $(TARGET)

$(BUILDDIR)/%.class: $(SOURCEDIR)/%.java
	mkdir -p bin
	javac -d $(BUILDDIR) $<

clean:
	rm -f $(BUILDDIR)/*.class
