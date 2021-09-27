
Pod::Spec.new do |s|
  s.name         = "RNKoreAiNativeWrapper"
  s.version      = "1.0.0"
  s.summary      = "RNKoreAiNativeWrapper"
  s.description  = <<-DESC
                  RNKoreAiNativeWrapper
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNKoreAiNativeWrapper.git", :tag => "master" }
  s.source_files  = "ios/*.{h,m}"
  s.requires_arc = true
  s.homepage = "https://github.com/"

  s.dependency "React"
  #s.dependency "others"

end

  