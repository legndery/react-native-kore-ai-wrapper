
# react-native-kore-ai-native-wrapper

## How to make wrappers:

1. There are 2-3 libraries that creates the project structure. `create-react-native-library` or `react-native-create-library`. I used `react-native-create-library` following [this artcle](https://medium.com/wix-engineering/creating-a-native-module-in-react-native-93bab0123e46) but some of the components may be outdated like jcenter repository or using `compile` instead of `implementation` but they are trivial things to fix. 

```
react-native-create-library -—platforms ios,android <projectFolder>
```
2. Now there is one Java file that needs to be changed and that is the *Module.java. Where you need to put the `ReactMethod`s or the interfaces you want to expose from the library. In this case I edited a little bit the Project that you sent and added those public methods.

3. If there are activities we need to register them at `AndroidManifest.xml`.

4. The required lbraries are put in `build.gradle` file and `lib` folder inside the `android` folder.


## Getting started

1. If you have a npm library pushed you can directly do this.
`$ npm install react-native-kore-ai-native-wrapper --save`

2. Otherwise you can tar the package or `npm pack` the package and install the local tar file.
```s
tar --exclude="<projectFolder>/android/.gradle" --exclude="<projectFolder>/.git" --exclude="<projectFolder>/android/.idea" -cvzf <tarName>.tar.gz <projectFolder>/

npm install path/to/<tarName>.tar.gz
```

### Mostly automatic installation

`$ react-native link react-native-kore-ai-native-wrapper`

### Alternate: Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-kore-ai-native-wrapper` and add `RNKoreAiNativeWrapper.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNKoreAiNativeWrapper.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNKoreAiNativeWrapperPackage;` to the imports at the top of the file
  - Add `new RNKoreAiNativeWrapperPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-kore-ai-native-wrapper'
  	project(':react-native-kore-ai-native-wrapper').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-kore-ai-native-wrapper/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-kore-ai-native-wrapper')
  	```

## Usage
```javascript
import RNKoreAiNativeWrapper from 'react-native-kore-ai-native-wrapper';

// TODO: What to do with the module?
RNKoreAiNativeWrapper;
```

## iOS Null native module troubleshoot:
### For Reference check this Commit: [910434157901dbe07fd74a4b5a7a03de767261c5](https://github.com/legndery/react-native-kore-ai-wrapper/commit/910434157901dbe07fd74a4b5a7a03de767261c5)
- Move the Podspec file to the root.
- Change the source_files to appropriate location. For example: `s.source_files  = "ios/*.{h,m}"`
- Add a `homepage` attribute to the podspec file. `s.homepage = "https://github.com/"`
- create podfile by running `cd ios && pod init` then move the `Podfile` again to root.
- Add the below dependencies (check the existing `Podfile` to get an idea):
```rb
pod 'yoga', :path => '../node_modules/react-native/ReactCommon/yoga'
pod 'React', :path => '../node_modules/react-native'
pod '<ur package name from package.json>', :path => '../node_modules/<ur package name from package.json>'
```
- now `npm pack` or tar the package and Npm install it as before in your project.
- In your project go to `ios` directory by doin `cd ios` and do `pod install` otherwise it will not be linked.
