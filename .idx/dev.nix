# To learn more about how to use Nix to configure your environment
# see: https://developers.google.com/idx/guides/customize-idx-env
{ pkgs, ... }: {
  # Which nixpkgs channel to use.
  channel = "stable-23.11"; # or "unstable"

  # Use https://search.nixos.org/packages to find packages
  packages = [
    pkgs.jdk11
    pkgs.maven
    pkgs.gradle
    pkgs.postman
    pkgs.jetbrains.idea-community
  ];

  # Sets environment variables in the workspace
  env = {
    JAVA_HOME = "${pkgs.jdk11}/lib/openjdk";
    PATH = "${pkgs.jdk11}/bin:${pkgs.maven}/bin:${pkgs.gradle}/bin:$PATH";
  };

  idx = {
    # Search for the extensions you want on https://open-vsx.org/ and use "publisher.id"
    extensions = [
      "vscjava.vscode-java-pack"
      "redhat.java"
      "vscjava.vscode-maven"
      "vscjava.vscode-gradle"
    ];

    # Enable previews
    previews = {
      enable = true;
      previews = {
        # No changes needed here for this project
      };
    };

    # Workspace lifecycle hooks
    workspace = {
      # Runs when a workspace is first created
      onCreate = {
        # Example: create a new Maven project
        # create-maven-project = "mvn archetype:generate -DgroupId=com.example -DartifactId=currency-converter -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false";
        
        # Note: Remember to add Gson dependency to your project's pom.xml or build.gradle
        # For Maven (in pom.xml):
        # <dependency>
        #     <groupId>com.google.code.gson</groupId>
        #     <artifactId>gson</artifactId>
        #     <version>2.10.1</version>
        # </dependency>
        #
        # For Gradle (in build.gradle):
        # implementation 'com.google.code.gson:gson:2.10.1'
      };
      # Runs when the workspace is (re)started
      onStart = {
        # No changes needed here for this project
      };
    };
  };
}