
# react-native-kore-ai-native-wrapper

## Getting started

`$ npm install react-native-kore-ai-native-wrapper --save`

### Mostly automatic installation

`$ react-native link react-native-kore-ai-native-wrapper`

### Manual installation


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

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNKoreAiNativeWrapper.sln` in `node_modules/react-native-kore-ai-native-wrapper/windows/RNKoreAiNativeWrapper.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Kore.Ai.Native.Wrapper.RNKoreAiNativeWrapper;` to the usings at the top of the file
  - Add `new RNKoreAiNativeWrapperPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNKoreAiNativeWrapper from 'react-native-kore-ai-native-wrapper';

// TODO: What to do with the module?
RNKoreAiNativeWrapper;
```
  