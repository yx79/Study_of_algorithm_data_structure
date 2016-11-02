//
//  Car.h
//  Classes
//
//  Created by Pomme on 11/1/16.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>

// interface is created with the @interface directive
@interface Car : NSObject {
    // Protected instance variables (not) recommented
    // since most developers treat instance variables as implementation details and prefer to store them in .m file instead of interface
}

// @property directives declares a public property, and the (copy) attribute defines its memory management behavior. In this case, the value assigned to model will be stored as a copy instead of a direct pointer.


@property (copy) NSString *model;


// init is the default initialization method, but you can also define your own versions to accept configuration parameters.
- (id)initWithModel:(NSString *)aModel;

// - is a instance method 
- (void)drive;

// class method declarations
+ (void)setDefualtModel:(NSString *)aModel;

@end
